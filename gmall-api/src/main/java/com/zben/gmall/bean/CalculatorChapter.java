package com.zben.gmall.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CalculatorChapter implements Serializable {
	private List<CalculatorChapter>  chapterList;
	/** 主键ID */
    private Integer chapterId;

    /** 文章ID */
    private Integer articleId;

    /** 医院id */
    private Long hisId;

    /** 父类ID */
    private String parentId;

    /** 是否有子章节：0 无  1有 */
    private Integer hasChild;

    /** 章节标题 */
    private String title;

    /** 状态 0.草稿箱 1.已发布 2.已下架  */
    private Integer status;

    /** 1 普通展示，2、展示时间地点 */
    private Integer showType;

    /** 内容链接 */
    private String contentUrl;

    /** 审核员 */
    private String auditAccount;

    /** 作者 */
    private String author;

    /** 文章标签，多个标签用英文逗号分割 */
    private String tags;

    /** 文章简述 */
    private String shortDesc;

    /** 扩展属性 */
    private String extFields;

    /** 发布渠道编码 */
    private Integer publishChannel;

    /** 发布时间 */
    private Date publishTime;

    /** 排序号 */
    private Integer sortNum;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /** 内容 */
    private String content;

    private static final long serialVersionUID = 1L;

    /** 主键ID */
    public Integer getChapterId() {
        return chapterId;
    }

    /** 主键ID */
    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    /** 文章ID */
    public Integer getArticleId() {
        return articleId;
    }

    /** 文章ID */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /** 医院id */
    public Long getHisId() {
        return hisId;
    }

    /** 医院id */
    public void setHisId(Long hisId) {
        this.hisId = hisId;
    }

    /** 父类ID */
    public String getParentId() {
        return parentId;
    }

    /** 父类ID */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /** 是否有子章节：0 无  1有 */
    public Integer getHasChild() {
        return hasChild;
    }

    /** 是否有子章节：0 无  1有 */
    public void setHasChild(Integer hasChild) {
        this.hasChild = hasChild;
    }

    /** 章节标题 */
    public String getTitle() {
        return title;
    }

    /** 章节标题 */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /** 状态 0.草稿箱 1.已发布 2.已下架  */
    public Integer getStatus() {
        return status;
    }

    /** 状态 0.草稿箱 1.已发布 2.已下架  */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 1 普通展示，2、展示时间地点 */
    public Integer getShowType() {
        return showType;
    }

    /** 1 普通展示，2、展示时间地点 */
    public void setShowType(Integer showType) {
        this.showType = showType;
    }

    /** 内容链接 */
    public String getContentUrl() {
        return contentUrl;
    }

    /** 内容链接 */
    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl == null ? null : contentUrl.trim();
    }

    /** 审核员 */
    public String getAuditAccount() {
        return auditAccount;
    }

    /** 审核员 */
    public void setAuditAccount(String auditAccount) {
        this.auditAccount = auditAccount == null ? null : auditAccount.trim();
    }

    /** 作者 */
    public String getAuthor() {
        return author;
    }

    /** 作者 */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /** 文章标签，多个标签用英文逗号分割 */
    public String getTags() {
        return tags;
    }

    /** 文章标签，多个标签用英文逗号分割 */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /** 文章简述 */
    public String getShortDesc() {
        return shortDesc;
    }

    /** 文章简述 */
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc == null ? null : shortDesc.trim();
    }

    /** 扩展属性 */
    public String getExtFields() {
        return extFields;
    }

    /** 扩展属性 */
    public void setExtFields(String extFields) {
        this.extFields = extFields == null ? null : extFields.trim();
    }

    /** 发布渠道编码 */
    public Integer getPublishChannel() {
        return publishChannel;
    }

    /** 发布渠道编码 */
    public void setPublishChannel(Integer publishChannel) {
        this.publishChannel = publishChannel;
    }

    /** 发布时间 */
    public Date getPublishTime() {
        return publishTime;
    }

    /** 发布时间 */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /** 排序号 */
    public Integer getSortNum() {
        return sortNum;
    }

    /** 排序号 */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    /** 创建时间 */
    public Date getCreateTime() {
        return createTime;
    }

    /** 创建时间 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /** 更新时间 */
    public Date getUpdateTime() {
        return updateTime;
    }

    /** 更新时间 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 内容 */
    public String getContent() {
        return content;
    }

    /** 内容 */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public List<CalculatorChapter> getChapterList() {
		return chapterList;
	}

	public void setChapterList(List<CalculatorChapter> chapterList) {
		this.chapterList = chapterList;
	}
}
