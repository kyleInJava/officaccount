package com.afficaccount.demo.common.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 包含二级菜单的二级按钮
 * @author kyle
 *
 */
@Getter
@Setter
public class ComplexButton extends Button {
	
	private List<Button> sub_button;

}
