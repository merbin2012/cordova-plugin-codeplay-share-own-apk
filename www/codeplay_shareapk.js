var exec = require('cordova/exec');
exports.openShare = function (arg0,arg1, success, error) {
	exec(success, error, 'codeplay_shareapk', 'openShare', [arg0,arg1]);
};