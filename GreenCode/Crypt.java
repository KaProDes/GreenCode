class Crypt extends AES{
  static String key = System.getenv("KEY");
  static String encrypt(String strToEncrypt){
    return AES.encrypt(strToEncrypt,key);
  }
  static String decrypt(String strToDecrypt){
    return AES.decrypt(strToDecrypt,key);
  }
}
