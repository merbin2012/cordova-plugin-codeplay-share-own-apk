cordova.define("cordova-plugin-codeplay-share-own-apk.codeplay_shareapk", function(require, exports, module) {
var exec = require('cordova/exec');

exports.openShare = function (arg0, success, error) {
    exec(success, error, 'codeplay_shareapk', 'openShare', [arg0]);
};


});
