from binascii import b2a_hex, a2b_hex

from Crypto.Cipher import AES

k = 'A'
o = ''''''
t = o.encode('utf-8')
print(b2a_hex(AES.new(k.encode('utf-8'), AES.MODE_CBC, k[::-1].encode()).encrypt((t.decode('utf-8') + ('\0' * (16 - (len(t) % 16) if len(t) % 16 else 0))).encode('utf-8'))).decode('utf-8'))
print(bytes.decode(AES.new(k.encode('utf-8'), AES.MODE_CBC, k[::-1].encode()).decrypt(a2b_hex(o))).rstrip('\0'))
