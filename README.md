# POJO Booster :rocket:
Giving steroids to your POJOs where setting dummy values can take huge amount of time and increase [sloc](https://en.wikipedia.org/wiki/Source_lines_of_code) in scenarios like writing tests. In writing tests, specifically, the goal is to see the code behaviour and/or results. Frameworks like Mockito combined with dependency managers makes it easy to manage objects that are used with the "code" that is going to be tested. So focus is mainly on writing tests rather than writing code for dependency management.

Sometimes, there is a need for data to be populated in bulk. Where the parameter is of [Java SE type](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html), you can use [Parameterized tests](https://github.com/junit-team/junit4/wiki/parameterized-tests) feature of JUnit. But what if your code to be tested completely depends on data objects you must provide. And these objects are your class templates. 

In fact, if these objects contains other objects, and those other objects and so on, setting dummy values can take a lot of time and also increases the lines of code written/executed in test cases. 

POJO Bolster will provide an annotation which will put dummy values to your objects at runtime. This will help you focus on writing tests and less time on writting setter calls for these objects.
