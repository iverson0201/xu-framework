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

print.call(a,"a"); // this ------> a, a继承print
print.call(b,"b");

//call 和 apply，这两个函数的差别就是参数的样子不一样，另一个就是性能不一样，apply的性能要差很多。
print.apply(a,["a"]); // this ------> a, a继承print
print.apply(b,["b"]);

console.log("=============\n");
var p = print.bind(a);
p("a"); // this => a, output "10 - a"
p.call(b,"b"); // this => a, output "10 - b"
p.apply(b,["b"]); // this => a, output "10 - b"














