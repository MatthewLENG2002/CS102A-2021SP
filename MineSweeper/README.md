

---
> Git is used in this project: https://github.com/MatthewLENG2002/CS102A-2021SP
> 
> 
> This project is built under `jdk16` environment,
> please use new syntactic features or simplify 
> your code as prompted by ide.  
>
> 
> eg1. for `listener`s, use `lambda expression`  
> > https://www.runoob.com/java/java8-lambda-expressions.html
> 
> eg2. use code seg 2 instead of seg 1.
> ```java
> // seg 1
> int a;
> switch (scanner.nextInt()) {
>     case 1:
>         a = 2;
>         break;
>     default:
>         a = 3;
>         break;
> }
> 
> // seg 2
> int a = switch (scanner.nextInt()) {
>     case 1 -> 2;
>     default -> 3;
> }
> ```
>
---
*Last modified: Matthew 05/26*