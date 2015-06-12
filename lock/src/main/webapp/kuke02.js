/**
 * Created by xu on 2015/6/11.
 */
//创建对象
var chenhao = Object.create(null);

//设置一个属性
Object.defineProperty( chenhao,
    'name', { value:  'Chen Hao',
        writable:     true,
        configurable: true,
        enumerable:   true });

//设置多个属性
Object.defineProperties( chenhao,
    {
        'email'  : { value:  'haoel@hotmail.com',
            writable:     true,
            configurable: true,
            enumerable:   true },
        'website': { value: 'http://coolshell.cn',
            writable:     true,
            configurable: true,
            enumerable:   true }
    }
);
var age = 0;
Object.defineProperty(chenhao,
    'age',{
        get : function(){
            return age + 1;
        },
        set : function(value){
            age = value;
        },
        enumerable : true,
        configurable : true
    }
);
chenhao.age = 100;
console.log(chenhao.age);

console.log("====================================");

//列出对象的属性
function listProperties(obj){
    var names = Object.getOwnPropertyNames(obj);
    for(i = 0;i < names.length;i++){
        var prop = names[i];
        console.log(prop);

        var descriptor = Object.getOwnPropertyDescriptor(obj,prop);
        for(var attr in descriptor){
            console.log(descriptor[attr]);
        }
    }
};
listProperties(chenhao);

