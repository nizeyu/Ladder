// hashSum = 33 * hashSum + key[i];
// 需要运用mod运算性质防止溢出
class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        
        long ans = 0;
        for (int i = 0; i < key.length; i++) {
            ans = (ans * 33 + (int)(key[i])) % HASH_SIZE;
        }
        
        return (int)ans;
    }
}
