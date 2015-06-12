/**
 * Created by xu on 2015/6/11.
 */
function print(text){
    console.log(this.value + " - " + text);
}
var a = {value :10,print:print};
var b = {value : 20,print : print};
print('hello'); // this ----> global

a.print('a'); // this -----> a
b.print('b');
a["print"]("a");

console.log("=======================");

print.call(a,"a"); // this ------> a, a�̳�print
print.call(b,"b");

//call �� apply�������������Ĳ����ǲ��������Ӳ�һ������һ���������ܲ�һ����apply������Ҫ��ܶࡣ
print.apply(a,["a"]); // this ------> a, a�̳�print
print.apply(b,["b"]);

console.log("=============\n");
var p = print.bind(a);
p("a"); // this => a, output "10 - a"
p.call(b,"b"); // this => a, output "10 - b"
p.apply(b,["b"]); // this => a, output "10 - b"














