var exec = require('cordova/exec');
exports.openShare = function (arg0,arg1, success, error) {
	exec(success, error, 'codeplay_shareapk', 'openShare', [arg0,arg1]);
};

exports.isSupport = function (success, error) {
	exec(success, error, 'codeplay_shareapk', 'isSupport');
};

exports.openShareFile = function (arg0,arg1,arg2, success, error) {
	exec(success, error, 'codeplay_shareapk', 'openShareFile', [arg0,arg1,arg2]);
};


exports.copyFile = function (sourcePath,distinationPath,shareFileName, success, error) {
	exec(success, error, 'codeplay_shareapk', 'copyFile', [sourcePath,distinationPath,shareFileName]);
};