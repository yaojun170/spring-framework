/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aopalliance.intercept;

import java.lang.reflect.Method;

/**
 * Description of an invocation to a method, given to an interceptor
 * upon method-call.
 * 描述一个方法调用，在方法调用时给出拦截器
 *
 * <p>A method invocation is a joinpoint and can be intercepted by a
 * method interceptor.
 * 方法调用是一个连接点，可以被方法拦截器拦截，
 * @author Rod Johnson
 * @see MethodInterceptor
 */
/*
 * 将方法调用中target,method,args等包装成MethodInvocation来代管方法调用proceed()
 * 参考实现：JDK代理实现ReflectiveMethodInvocation，而CGLIB交给CglibMethodInvocation
 * 使用场景：MethodInterceptor
 * 使用参考：JdkDynamicAopProxy.invoke()方法中构造MethodInvocation
 */
public interface MethodInvocation extends Invocation {

	/**
	 * Get the method being called.
	 * <p>This method is a frienly implementation of the
	 * {@link Joinpoint#getStaticPart()} method (same result).
	 * @return the method being called
	 */
	Method getMethod();

}
