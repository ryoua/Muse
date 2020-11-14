package com.muse.dispatch.filter.blacklist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
** @Author: RyouA
** @Date: 2020/11/14
**/
/**
    * 黑名单详细表
    */
@ApiModel(value="com-muse-dispatch-filter-blacklist-model-BlackListItem")
@Getter
@Setter
@ToString
public class BlackListItem implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private Long bid;

    @ApiModelProperty(value="")
    private String item;

    private static final long serialVersionUID = 1L;
}