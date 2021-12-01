# Online-mall-system
#### 一、新建动态项目
#### 二、新建用户数据库表：t_user（cid、username、password、phone） 
#### 三、创建用户实体类，（build path导入lombok）添加get/set方法
#### 四、导入jar包：beanutils、dbutils、logging、druid、mysql-connector、connection
 
#### 五、注册页面
1、判断用户输入是否为空，为空则给出提示信息，同时对两次输入的密码进行检查，若一致则提交到表单  
【切记】不要码错JS，不然特难找错  
【不足】当用户点击提交才会有提示  
2、添加CheckCodeServlet程序和words.txt，实现验证码动态显示  
【切记】点击事件应该是在图片上，不要错误添加  
【要点】通过添加时间戳来刷新验证码  
 
3、用户注册  
 
- 接收验证码信息是否正确，若正确则进行注册保存  
1、接收用户注册表单信息  
2、封装成user对象，并设置用户id  
3、调用service层方法添加用户到数据库表中  
4、注册成功跳转到登录页面  
 
- 验证码错误则注册失败，跳转到页面进行重新注册  
【切记】一定要设置接收字符集编码格式，尤其是要标注post请求方式  
【要点】使用MVC框架，分别为web层、service层和dao层  
【不足】只是简单的通过验证码是否正确进行注册，同时未给出提示信息  

#### 六、登录页面
1、用户登录  
 - 用户信息正确，则跳转到欢迎页  
   1、接收用户登录表单参数  
   2、调用service层方法查询用户信息是否正确，若正确则将用户信息存入session域中，方便在JSP文件中取用，同时跳转到欢迎页  
   3、在欢迎页中显示用户信息，需要使用JSTL标签库
 
 
 - 用户信息不正确，则跳转到登录页面
	 【切记】参数名不能写错，否则获取不到用户信息，同时也需要设置字符集编码格式
	 【要点】使用MVC框架，用户信息保存到session会话中，而不是一次请求就结束的request域中
	 【不足】在页面中未给出登录错误提示  
2、用户退出
	销毁session会话对象，进行页面跳转
 
#### 七、系统管理员
1、登录页面
	 * 新建管理员数据表：t_admin（id，username，password）
	 * 添加管理员实体类，设置get/set方法
	 * 设置登录提交地址，接收管理员登录信息
   * 连接数据库，调用service层查找管理员信息是否正确，若正确则将其存入session域中，若不正确则跳转到登录页面
   * 在service层中返回查找结果，若为空则抛出用户名或密码错误异常，并在servlet中接收错误信息，同时存入request请求域中  
【要点】使用MVC框架，同时将登录错误信息存入域中显示在页面上  
 
 
2、修改JSP文件中的地址为绝对路径：main、admin_index、admin_login  
 
 
 
#### 八、商品列表
新建商品数据表：t_goods（gid，gname，gprice，gimage，gdesc，gis_hot，cid）  
新建商品分类表：t_category（cid，cname）  
在商品表中添加外键为cid，实现商品类别同步。同时为每一个表添加实体类  
 
1、设置商品列表跳转地址：GoodsServlet?action=listServlet  
 2、调用service层查找全部商品的方法，获取全部商品对象后存入request请求域中，跳转转发到商品列表页显示  
 
 
#### 九、商品管理
1、添加商品  
* 点击新增按钮添加商品。首先获取商品全部分类，采用MVC架构实现，同时存入request请求域中，以便在add.jsp中获取。    
* 添加提交。使用JS表达式在表单中添加点击事件，在servlet中接收商品信息，封装成goods对象，调用service层添加方法，实现商品添加到数据库中，并返回到商品查询列表进行显示。    
【切记】接收表单参数时，要保持与数据库表的名称一致，否则会获取不到数据，同时需要考虑submit和button提交数据的区别  
【要点】先从数据库中获取商品的分类显示，然后添加商品到数据库中  
 
 
 
2、删除商品  
* 根据id实现商品删除  
* 接收商品id，调用service层，删除成功返回商品列表  
【要点】插入更新删除使用update  
 
 
3、编辑商品  
* 点击编辑按钮跳转到编辑页面。   
1、传入商品的id，根据id获取商品原先的信息，并存入请求域中    
2、获取商品的全部分类，同时也存入请求域中，并跳转到编辑页面   
* 更新商品信息保存到数据库    
1、在edit.jsp文件中设置表单提交地址，同时添加提交事件，为获取表单数据，需要添加name属性等    
2、接收表单数据，封装成goods对象，调用service层实现商品信息的更新，修改成功后跳转到商品列表页面  
【切记】JSP文件中的name属性一定要和数据库表中的字段名一致，同时id和name属性不能搞混，地址要使用绝对路径      
【要点】先接收原先的商品数据，然后修改商品信息更新到数据库中。同时，为了在更新时获取商品id，需要额外增加一个input标签语句，display属性设置为none，这是一个小技巧！为获取商品分类，需要导入JSTL标签库，使用JS表达式为分类和热门设置属性值  
【不足】没有添加更新失败异常  
 
 
 
 
 

#### 十、商品分页  
1、创建PageBean实体类，设置当前页、总记录数、总页数和当前页的商品  
2、根据接收当前页来显示商品数。调用service层，获取PageBean，存入请求域中，并转发到main.jsp中  
3、在GoodsService中添加getPageBean获取，需要设置当前页、获取并设置总记录数、设置一页显示的商品数、计算并设置总页数，以及获取并设置当前页的商品，调用dao层获取。  
4、修改main.jsp中显示商品的代码  
【要点】根据当前页码来分页显示商品，需要传currentPage参数
 
 
 
 

 

#### 十一、The above HTML, css, images, js are all downloaded from the Internet，not written by myself
