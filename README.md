# POJO Booster :rocket:
Giving steroids to your POJOs where setting dummy values can take huge amount of time and increase [sloc](https://en.wikipedia.org/wiki/Source_lines_of_code) in scenarios like writing tests. In writing tests, specifically, the goal is to see the code behaviour and/or results. Frameworks like Mockito combined with dependency managers makes it easy to manage objects that are used with the "code" that is going to be tested. So focus is mainly on writing tests rather than writing code for dependency management.

Sometimes, there is a need for data to be populated in bulk. Where the parameter is of [Java SE type](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html), you can use [Parameterized tests](https://github.com/junit-team/junit4/wiki/parameterized-tests) feature of JUnit. But what if your code to be tested completely depends on data objects you must provide. And these objects are your class templates. 

In fact, if these objects contains other objects, and those other objects and so on, setting dummy values can take a lot of time and also increases the lines of code written/executed in test cases. 

POJO Booster will provide an annotation which will put dummy values to your objects at runtime. This will help you focus on writing tests and less time on writting setter calls for these objects.



### Advantages
- Use this to populate dummy values for scenarios like writing test cases.
- Saves time by preventing developers from calling dozens of setters or mock calls.
- Loops down the child objects and also initializes them.
- Gives flexibility to set specified values by the user.


## Release
Available Version:  [1.0](https://github.com/talhahasanzia/pojo-booster/releases/tag/v1.0)


## Library Source
[Jump to library source.](https://github.com/talhahasanzia/pojo-booster/tree/master/src/io/github/talhahasanzia)

## Getting Started
- Consider you are writing test, and you use a SampleDto class, following example illustrates how can you use this library to generate data.


```

public class TestCase extends Test
 {
 
    @Boost
    private SampleDto sampleDto;
    
    @Before
    public void setup(){
      // Call initializer to start boosters      
      PojoBooster.boost( this );
    }
    
    
    @Test
    public void testDto(){
      // start testing dto with dummy values
      assertNotNull(sampleDto);
    }
    
    
 
 ...
 }
 
 // to set your values
 
 public class SampleDto{
 
    // specify length and character set
    
    @CharacterConfig(length = 8, characterSet = CharacterSet.ALPHABETS)
    String name;
    
    String address;
    
    // mark this as unsigned, to be generated with only positive values
    
    @Unsigned
    int age;
    
    // set exact value
    
    @TestValue( booleanValue = true )
    boolean isValidUser;
    
    Double signature;
 
 }
  
 ```

## Change Log

**1.0**

Generating values including child objects. Also configure String, Character and Number variables with provided annotations.



## Contributing

- Contributions are welcomed as long as they dont break the code. Please create an issue and have a discussion before pull request.
- There is still WIP so don't hesitate to report issues or pull requests.
- Also, if you created a skin based on this library you can create a pull request and we will add it in official release.



## Authors

* **Talha** - *Initial work* - [@talhahasanzia](https://github.com/talhahasanzia)

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](https://github.com/talhahasanzia/pojo-booster/blob/master/LICENSE) file for details.


