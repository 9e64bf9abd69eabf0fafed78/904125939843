import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author nobody
 */
public class Invoice {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<BigDecimal> array = new ArrayList<>();
        System.err.println("输入你所有可用于选择的发票，用“+”分隔：");
        if (sc.hasNextLine()) {
            String[] doubles = sc.nextLine().split("\\+");
            if (doubles.length < 3) {
                throw new Exception("少于三张发票，请自行计算 !");
            }
            array = Arrays.stream(doubles).map(s -> BigDecimal.valueOf(Double.parseDouble(s)).setScale(2, RoundingMode.HALF_UP)).sorted().collect(Collectors.toList());
        }
        System.err.println("输入你的目标报销金额：");
        double tar = 0.0;
        if (sc.hasNextBigDecimal()) {
            tar = sc.nextBigDecimal().doubleValue();
        }
        final double target = tar;
        if (target <= 0.0) {
            throw new Exception("报销金额必须是正数");
        }
        if (array.get(0).doubleValue() >= target) {
            System.out.println(array.get(0));
            return;
        }
        if (target >= array.stream().mapToDouble(BigDecimal::doubleValue).sum()) {
            throw new Exception("所有发票的面额之和小于目标报销金额");
        }
        BigDecimal[] bigger = array.stream().filter(b -> b.doubleValue() >= target).sorted().toArray(BigDecimal[]::new);
        if (bigger.length > 0 && bigger[0].doubleValue() == target) {
            System.out.println(bigger[0]);
            return;
        }
        BigDecimal[] smaller = array.stream().filter(s -> s.doubleValue() < target).sorted().toArray(BigDecimal[]::new);
        double ss = Arrays.stream(smaller).mapToDouble(BigDecimal::doubleValue).sum();
        if (Double.valueOf(target).equals(ss)) {
            System.out.println(Arrays.stream(smaller).map(Object::toString).collect(Collectors.joining(" + ")));
            System.out.println(ss);
            return;
        } else if (target > ss && bigger.length > 0) {
            System.out.println(bigger[0]);
            return;
        }
        if (smaller.length > 1) {
            List<BigDecimal> smallerList = new ArrayList<>(Arrays.asList(smaller));
            if (bigger.length > 0) {
                smallerList.add(bigger[0]);
            }
            Map<BigDecimal, List<BigDecimal>> combines = new IdentityHashMap<>(16);
            long n = (long) Math.pow(2, smallerList.size());
            List<BigDecimal> combine;
            for (long l = 0L; l < n; l++) {
                combine = new ArrayList<>();
                for (int i = 0; i < smallerList.size(); i++) {
                    if ((l >>> i & 1) == 1) {
                        combine.add(smallerList.get(i));
                    }
                }
                if (combine.size() > 1) {
                    BigDecimal reduce = combine.stream().reduce(BigDecimal::add).get();
                    if (reduce.doubleValue() >= target) {
                        combines.put(reduce, combine);
                    }
                }
            }
            if (combines.size() == 0) {
                throw new Exception("无最佳组合");
            }
            Map<List<BigDecimal>, BigDecimal> re = new LinkedHashMap<>();
            combines.keySet().stream().sorted().limit(10).forEach(k -> re.put(combines.get(k), k));
            System.out.println("最佳组合如下：");
            for (List<BigDecimal> d : re.keySet().stream().sorted(Comparator.comparing(re::get)).collect(Collectors.toList())) {
                System.out.println(re.get(d).stripTrailingZeros().toPlainString() + " = " + d.stream().map(s -> s.stripTrailingZeros().toPlainString()).collect(Collectors.joining(" + ")));
            }
        }
    }
}