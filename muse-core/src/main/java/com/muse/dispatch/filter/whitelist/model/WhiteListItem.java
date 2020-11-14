package com.muse.dispatch.filter.whitelist.model;

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
    * 白名单详细表
    */
@ApiModel(value="com-muse-dispatch-filter-whitelist-model-WhiteListItem")
@Getter
@Setter
@ToString
public class WhiteListItem implements Serializable {
    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="")
    private String item;

    @ApiModelProperty(value="")
    private String wid;

    private static final long serialVersionUID = 1L;
}