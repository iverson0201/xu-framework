/**
 * Created by xu on 2015/6/11.
 */
//��������
var chenhao = Object.create(null);

//����һ������
Object.defineProperty( chenhao,
    'name', { value:  'Chen Hao',
        writable:     true,
        configurable: true,
        enumerable:   true });

//���ö������
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

//�г����������
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

