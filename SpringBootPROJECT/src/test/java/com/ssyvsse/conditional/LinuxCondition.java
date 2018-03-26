package com.ssyvsse.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author llb
 *
 * @Date 2018年3月24日 下午7:46:26
 */
public class LinuxCondition implements Condition {

	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
		return conditionContext.getEnvironment().getProperty("os.name").contains("Linux");
	}

}
