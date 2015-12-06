var md5 = require('md5');

var check = new RegExp('^0{5}[^0]');
var secret_key = 'ckczppom';
var number = 1;
while (true) {
    var message = md5(secret_key + number);
    if (message.match(check)) {
        console.log(number);
        break;
    }
    number++;
}
