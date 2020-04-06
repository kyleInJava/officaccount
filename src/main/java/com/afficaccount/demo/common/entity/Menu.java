package com.afficaccount.demo.common.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 主菜单，里面包含的都是一级按钮
 * @author kyle
 *
 */
@Setter
@Getter
public class Menu {
	
	private List<Button> button;

}
