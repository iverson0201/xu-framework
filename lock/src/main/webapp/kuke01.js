/**
 * Created by xu on 2015/6/11.
 * http://coolshell.cn/articles/6441.html
 */
var name = "Chen Hao";
var email = "xu0201@163.com";
var website = 'http://www.hao123.com';

var chenhao = {
    name : 'chen hao',
    email : "tracy@163.com",
    website : "http://www.hao123.com"
};

//�Գ�Ա�ķ�ʽ
console.log(chenhao.name);
//��hash map�ķ�ʽ
console.log(chenhao["email"]);

var doSomething = function(){
    console.log("hello");
};
doSomething();

var sayHello = function(){
    var hello = "hello, I'm " + this.name + "  " + email;
    console.log(hello);
};
//ֱ�Ӹ�ֵ���������C/C++�ĺ���ָ��
chenhao.say = sayHello;
chenhao.say();
delete chenhao["name"];
chenhao.say();

//��function����class
var Person = function(name,email,website){
    this.name = name;
    this.email = email;
    this.website = website;

    this.helloWorld = function(){
        var hello = "hello, I'm " + this.name + "  " + this.email;
        console.log(hello);
    }
};

var xu = new Person("xu","xu123@qq.com","http://www.baidu.com");
var xu = new Person("xujw");
xu.helloWorld();



