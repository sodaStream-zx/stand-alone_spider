package com.finding.myspider.spiderTools.contentSelector;

/**
 * desc: 网页内容提取接口
 **/
public interface ContentSelect {
    String titleSelect();
    String urlSelect();
    String contSelect();
    String mediaSelect();
    String authorSelect();
    String timeSelect();
}
