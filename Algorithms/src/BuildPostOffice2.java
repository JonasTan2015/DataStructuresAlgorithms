/*
 * 给你一个矩阵。 1 的位置代表房子，0的位置代表空地, 2的位置代表墙
 * 现在需要建造1间post office。使得所有房子到这个office 距离之和最小。 返回这个距离。如果不可能，返回-1
 * Post office 只能建在空地。人可以穿过其他房屋到达post office，人不能穿墙
 *
 * 思路：我们可以对矩阵里面每一个的空地都算一次到所有房子的距离值和。但是这样会超时
 * 优化思路：先预处理。建一个dp[i][j][k]， i表示第i间房子，一开始先用hashmap将房子编号。 j, k表是 坐标 (j, k). 整个意思是第i间房子
 * 到坐标(j,k)的距离。 这样我们就可以通过
 */

public class BuildPostOffice2 {
    
}
