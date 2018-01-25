# note-guava
谷歌开源框架Guava的学习笔记，在这里逐步熟悉和简单实践。

## Guava是什么？
[Guava](https://github.com/google/guava)

上面是谷歌在github上开源的Guava地址，要想知道它是什么，进去一瞧便知。

## 为什么要学习Guava？
原本我在学习[Android Architecture Blueprints](https://github.com/googlesamples/android-architecture)，其中各个分支，是以`Todo`这个应用为基础，来展示不同的程序开发模式。比如`mvp`、`mvvm`这些，还有一些框架的使用，像`dagger`、`rxjava`、`databinding`等等。我切换到`todo-mvvm-databinding`和`todo-mvvm-live`分支，简单看了下，虽然其中的`databinding`并没有深入使用，`mvvm`开发模式比`mvp`开发模式也没有提升多少，但是有趣的是，它们居然都依赖了`Guava`框架。我对于`Guava`提供的清晰而又漂亮的辅助方法，相当感兴趣，所以转而来学习它，准备用到未来需要开发的项目中。

## 从普遍意义上来讲，为什么学习Guava？
- 谷歌工程师特别NB，他们开发出来的东西，肯定也很厉害
- 他们在开发Android或其他生态的时候，自然会比我们这些刚起步的小家伙，遭遇更多的Java诟病，所以他们的经验值得学习
- 走前人们建立的路，自然会提升开发效率，少走弯路就意味着时间成本的降低，并且得到更好的程序设计体验

**总之，使用Guava你会认为Java也是不错的语言，至少不会再有那么多样板代码，需要你不断地折磨自己**
