### Jetpack 学习
#### 1、 ConstraintLayout 学习
ConstraintLayout 主要是图形化不布局的，左上角选择各种控件，上方选择一些辅助工具，包括引导线，分组，边界等。

常用的技巧：

1、使用 Group

2、使用 Barrier

3、使用 GuideLine,GuideLine 使用百分比，点击左侧进行切换具体数值与百分比。


#### 2、语言本地化
首先资源国际化，不仅仅是字符串的国际化，可能包括显示的格式，如手机号码显示等这些布局可能都需要国际化，也就是，可能还会需要多个布局文件。

以字符串国际化为例。

在 String.xml 里面,打开右上角的 OpenEditor,就可以进行多语言编辑界面，这里可以进行编辑和添加。



#### 3、横竖屏适配
都过定义横屏和竖屏两个布局来进行视频。

一般还是都过比例来进行适配，尽量不能使用具体的数值。

需要注意的是，横竖屏切换之后，Activity 会销毁重建。

可以通过 onCreate 里面的 saveInstanceSate 保存，也可以禁止销毁来解决。

还一个，按 home 键回到桌面和 按 back 回到桌面，是不一样的。back 会销毁的。



#### 4、jepack viewmodel 
1、管理数据数据不会丢失

2、和 lifedata 配合使用，对数据进行监听（自动刷新）

使用步骤：

1、新建一个自定义的 ViewModel 继承自 库里面的 ViewModel

2、在这个ViewModel 里面声明 public 类型的数据。

3、在 Activity 或者 Fragment 里面通过 ViewModelProviders 获取 ViewModel(和当前的控制器绑定)
```
   dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);

```

4、通过获取的这个 ViewModel 实例来使用里面保存的变量


注意事项：

如果想要销毁重建之后，界面显示的数据依然正确，需要在 onCreate 每次都设置一下 ViewModel 的数据，也就是 ViewModel 保存的数据不会被销毁，

但是 onCreate 执行之后需要我们自己手动去设置回来这个数据。




#### 5、LiveData

作用：

1、数据更改之后通知界面更新。（不需要手动更新）

LiveData 的使用：

1、ViewModel 里面设置 MutableLiveData 类型的数据。

2、构造函数初始化变量（或者判空处理）

3、重写 setter/getter 函数

```
public class DashboardViewModel extends ViewModel {

    //1、使用 private
    //2、通过 构造函数初始化
    //3、重写一下 setter/getter
    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


    public void setText(String s){
        mText.setValue(s);
    }
}
```

4、Controller （Activity 或 Fragment ） 里面绑定 ViewModel
```
        //ViewModel 和 当前控制器的绑定
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

```


5、viewmodel 添加观察者对象，当数据改变是通知更新
```
       //数据添加观察者，并且有改变后更新。
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

```

6、通过 setter 函数更新数据,界面当得到自动更新
```
    dashboardViewModel.setText("这是通过 ViewModel 改变的");
```



#### 6、DataBanding
通过 DataBanding 来使 Controller 和 View 联系到一起。

常规的做法是：自己手动 findViewById 来进行 view 绑定。


使用：

1、build.gradle 里面声明使用 databanding
```
    dataBinding{
            enabled true
        }
```

2、界面布局 conver to databanding layout 

也就是最外层用 layout，同时，会有 data 闭包。


3、activity 里面不在使用 setContView
使用 DataBindUtil 就可以绑定布局，并且返回的 binding 对象会包含布局里面的所有成员。


fragment 还是需要在 onCreateView 里面返回 View
```

binding =  DataBindingUtil.inflate(inflater, R.layout.layout_ui_widget,container,false);


View root = binding.getRoot();//inflater.inflate(R.layout.test_fragment_idcard, container, false);

return root;

```

4、controller 里面可以不在使用 findViewById，而是通过 binding.xxx 的形式使用布局中的成员

5、数据绑定到 layout
layout 完善 data
```
    <data>
        <variable
            name="data"
            type="com.hc.jetpackdemo.ui.dashboard.DashboardViewModel" />
    </data>
```

这样，就可以在布局文件中使用这个 model
```
            android:text="@{data.text}"
```

```
            android:onClick="@{()->data.setText()}"

```

6、activity 里面的所有，监听事件，和ViewModel 的交互都可以删除掉了
```
public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    
    LayoutUiWidgetBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //ViewModel 和 当前控制器的绑定
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

        binding =  DataBindingUtil.inflate(inflater, R.layout.layout_ui_widget,container,false);

        binding.setData(dashboardViewModel);
        binding.setLifecycleOwner(this);
        View root = binding.getRoot();//inflater.inflate(R.layout.test_fragment_idcard, container, false);
        
        return root;
    }
}
```

也就是，layout 的数据，自己管理（改变），自己更新界面。activity 只和这个绑定即可。

注意一下语句必不可少
```
        binding.setData(dashboardViewModel);
        binding.setLifecycleOwner(this);
```



#### 7、ViewModel 在进程被杀死的情况下保存数据
开发者选项设置不保留活动，点击 Home 键，程序被杀死。（依然会调用 onPause 和 onDestroy）

方法一：

onSaveInstance 中保存数据。

onCreate 中恢复数据。


方法二：

1、添加 viewmodel_savedState 依赖。

2、重写 ViewModel 构造方法，加入 SavedStateHandle 参数，并在构造函数中恢复数据

3、handle 中的数据可以自动保存，只在取数据的时候恢复即可。


通过这种方式，ViewModel 保存的数据的生命周期会更长。



#### 8、SP 保存数据
android 保存数据的方式： 内部存储（沙盒）、外部、SP，DB 。

