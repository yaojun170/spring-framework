## 执行自定义main和单测的问题
1. 执行main，当前需要在build and run using:Gradle的配置下才能成功
2. 执行单测@Test，run tests using：可以设置成Intellij Idea

#### QA
1. 代码中用到了@Deprecated，编译失败，报已过时  
可以关闭限制，在build.gradle中将-Xlint:deprecation改为-Xlint:-deprecation