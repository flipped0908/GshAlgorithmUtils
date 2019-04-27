package gsh.demo.practice06_bigdataAndSpaceLimit;

/**
 *  不安全的网页一有 100 亿个黑名单 每个url 最多 64b
 *
 *
 *  2^10 = 1024   64= 2^6
 *
 *  10 亿 2^30
 *
 *  100 亿
 *
 *  10亿 = 1GB
 *
 *  64*10 * 10亿  = 640GB  0.64T
 *
 */

/**
 *  bloom 过滤器
 */

public class Code01_BlongFliter {

    /**
     *
     * 长度为 m 的bit 类型数组
     *
     *
     * k个 hash 函数
     *
     * 每个对象 经过 一个hash 函数 之后  对 % m  取余 把bloom bitarray 的值 从 0 改为 1
     *
     * 当在过来对象时候   发现未知不等于 1 说明之前没有来过
     *
     */


}



// 总结：


/**
 *
 * 如果过 内存不够用 就用 hash 函数把大文件 分割拆安分  一致划分到满足资源限制
 *
 * 内存 计算时间
 *
 * hash 函数分流  同一个hash函数 一定会被分流到同一个地方
 *
 * hash函数的一个性质  相同对象的 hash 值一定是相同的
 *
 * hash 函数 还有一个重要的性质 是 会均匀的散列
 *
 *
 */

