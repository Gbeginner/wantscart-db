package com.wantscart.jade.datasource.router;

/**
 * 实现: HEX-HASH 算法进行散表的配置记录。
 * 
 * 只取字符串的后两位字符进行散表。
 * 
 * @author han.liao
 */
public class HexHashRouter extends HashRouter {

    /**
     * 创建配置记录。
     * 
     *  column - 配置的列
     *  pattern - 数据表的名称模板
     *  count - 散列表数目
     */
    public HexHashRouter(String column, String pattern, int count) {
        super(column, pattern, count);
    }

    @Override
    protected long convert(Object columnValue) {

        if (count > 256) {
            throw new IllegalArgumentException("[Hex hash] Partitions must less than 256");
        }

        String stringValue = String.valueOf(columnValue);

        final int length = stringValue.length();

        if (length < 2) {
            throw new IllegalArgumentException("[Hex hash] Column \'" + column // NL
                    + "\' must have more than 2 characters");
        }

        try {
            // 转换成字符串处理
            return Long.parseLong(stringValue.substring(length - 2), 16);

        } catch (NumberFormatException e) {

            // 输出日志
            if (logger.isWarnEnabled()) {
                logger.warn("[Hex hash] Column \'" + column // NL
                        + "\' must be hex number, but: " + columnValue);
            }

            throw new IllegalArgumentException("Column \'" + column // NL
                    + "\' must be hex number, but: " + columnValue);
        }
    }

}
