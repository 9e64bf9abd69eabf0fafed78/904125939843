# -*- coding: utf-8 -*-
import random
import smtplib
from email.header import Header
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.utils import formataddr

from tencentcloud.common import credential
from tencentcloud.common.exception.tencent_cloud_sdk_exception import TencentCloudSDKException
from tencentcloud.common.profile.client_profile import ClientProfile
from tencentcloud.common.profile.http_profile import HttpProfile
from tencentcloud.sms.v20210111 import sms_client, models


def sms(aki: str, aks: str, app_id: int, sign: str, phones: list, template_id: int, parameter: list):
    """短信发送
    :param aki: The secret id of your credential.
    :param aks: The secret key of your credential.
    :param app_id: 短信 SdkAppId，在 [短信控制台](https://console.cloud.tencent.com/smsv2/app-manage)  添加应用后生成的实际 SdkAppId，示例如1400006666。
    :param sign: 短信签名内容，国内短信必填，使用 UTF-8 编码，必须填写已审核通过的签名。
    :param phones: 下发手机号码，采用 E.164 标准，格式为+[国家或地区码][手机号]，单次请求最多支持200个手机号且要求全为境内手机号或全为境外手机号。例如：+8613711112222。
    :param template_id: 模板 ID，必须填写已审核通过的模板 ID。模板 ID 可前往 [国内短信](https://console.cloud.tencent.com/smsv2/csms-template)
    :param parameter: 模板参数，若无模板参数，则设置为空。
    """
    try:
        hp = HttpProfile()
        hp.endpoint = "sms.tencentcloudapi.com"
        cp = ClientProfile()
        cp.httpProfile = hp
        client = sms_client.SmsClient(credential.Credential(aki, aks), "ap-nanjing", cp)
        req = models.SendSmsRequest()
        req.SmsSdkAppId = str(app_id)
        req.SignName = sign
        req.PhoneNumberSet = phones
        req.TemplateId = str(template_id)
        param_set = []
        for pp in parameter:
            if pp != '':
                param_set.append('[%s]' % pp)
        req.TemplateParamSet = param_set
        client.SendSms(req)
    except TencentCloudSDKException as e:
        print(e)


def email(sender: list, receivers: list, subject: str, content: str = '', host: str = 'smtp.163.com'):
    """邮件发送
    :param sender: ['发信邮箱', '发信人昵称', '发信邮箱校验码']
    :param receivers: ['收信邮箱A', '收信邮箱B'，...]
    :param content: 正文
    :param subject: 标题
    :param host: smtp服务器host
    """
    try:
        for receiver in set(receivers):
            sm = smtplib.SMTP_SSL(host=host, port=smtplib.SMTP_SSL_PORT)
            sm.login(sender[0], sender[2])
            msg = MIMEMultipart()
            if content:
                msg.attach(MIMEText(content, 'plain', 'utf-8'))
            if sender[1]:
                msg['From'] = formataddr([sender[1], sender[0]])
            msg['Subject'] = Header(subject, 'utf-8')
            # msg['To'] = Header(receiver, 'utf-8') # 非必填
            # attachment = MIMEText(open("附件.txt", 'rb').read(), 'base64', 'utf-8')
            # attachment["Content-Type"] = 'application/octet-stream'
            # attachment["Content-Disposition"] = 'attachment; filename="附件显示的名字"'
            # msg.attach(attachment)
            sm.sendmail(sender[0], receiver, msg.as_string())
            sm.quit()
    except Exception as email_err:
        print(email_err)


def is_number(s):
    try:
        float(s)
        return True
    except ValueError:
        pass
    import unicodedata
    try:
        unicodedata.numeric(s)
        return True
    except (TypeError, ValueError):
        pass
    if len(s) < 2:
        return False
    try:
        d = 0
        if s.startswith('－'):
            s = s[1:]
        for c in s:
            if c == '－':  # 全角减号
                return False

            if c == '．':  # 全角点号
                if d > 0:
                    return False
                else:
                    d = 1
                    continue
            unicodedata.numeric(c)
        return True
    except (TypeError, ValueError):
        pass
    return False


def simple_email(to: set, sender: str, subject: str):
    # 发自己
    if sender not in to:
        to.add(sender)
    for receiver in to:
        if receiver:
            sm = smtplib.SMTP_SSL('smtp.163.com', port=smtplib.SMTP_SSL_PORT)
            sm.login(sender, '登陆码')
            msg = MIMEText('' if receiver in [sender] else '正文')
            msg['Subject'] = Header(subject, 'utf-8')
            sm.sendmail(sender, receiver, msg.as_string())
            sm.quit()


def subway():
    total = 0
    single = int(input("输入单程票价: "))
    single = 3 if single < 4 else single
    for i in range(1, 23 * 2 + 1):
        print('第' + str(int((i + 1) / 2)) + '个工作日' + ('上' if i % 2 == 1 else '下') + '班：')
        m = '花费'
        if total < 100:
            total = total + single
            m = m + str(single)
        elif 150 > total >= 100:
            price = round(single * 0.8, 1)
            total = round(total + price, 1)
            m = m + str(price)
        elif 400 > total >= 150:
            price = round(single * 0.5, 1)
            total = round(total + price, 1)
            m = m + str(price)
        elif total > 400:
            total = round(total + single, 1)
            m = m + str(single)
        print(m + '元，当前总计' + str(total) + '元')
    print('花费总计：' + str(total) + '元')


def header(h_host: str = None):
    ip = str(random.randint(11, 99)) + '.' + str(random.randint(2, 99)) + '.' + str(random.randint(3, 99)) + '.' + str(random.randint(4, 99))
    return {
        'Host': h_host,
        'Access-Control-Allow-Credentials': 'true',
        'User-Agent': 'Opera/9.80 (Windows NT 6.0) Presto/2.12.388 Version/12.14',
        'X-Real-IP': ip, 'X-Forwarded-For': ip,
        'Accept-Language': 'zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6',
        'Accept-Encoding': 'gzip, deflate, br', 'Upgrade-Insecure-Requests': '1',
        'DNT': '1', 'Connection': 'keep-alive', 'Content-Type': 'text/html; charset=UTF-8',
        'Accept': r'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8'
    }
