Usage:
    ant init compile    % for compiling
    ant javadoc         % for generating javadoc
    ant dist run        % for generating executable jar file and running the application
    ant copy            % for copying the doc file
    ant clean           % delete the output files

Explanation Singleton pattern:

Reference:
https://www.javaworld.com/article/2073352/core-java/simply-singleton.html
https://www.tutorialspoint.com/java/java_using_singleton.htm

Singleton pattern makes sure that that only one instance of a class is created. Its
implementation usually consists of a private constructor and a field to hold its
result, and a static accessor method which return the instance. The technique used to
create the singleton known as lazy instantiation, which refers to the fact that the
singleton instance is not created until the method to access the instance, for example,
getInstance(), is called for the first time. This would make sure that singleton instances
are created only when needed. A private constructor is needed so clients cannot instantiate
Singleton instances.
