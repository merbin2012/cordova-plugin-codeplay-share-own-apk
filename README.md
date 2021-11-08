<h1>Code Play Share apk</h1>

Developed  by <a target="_blank" href="https://play.google.com/store/apps/details?id=com.HTML.AngularJS.Codeplay">HTML Code Play</a> and this plugin is used for share your current own apk through any other sharing applications for your cordova applications.

<h2>Git URL</h2>
https://github.com/merbin2012/cordova-plugin-codeplay-share-own-apk


<h2>How to Instalation?</h2>
<h4>Using the Cordova CLI</h4>
<blockquote>
  $ cordova plugin add cordova-plugin-codeplay-share-own-apk
</blockquote>


<h4>Using the phonegap CLI</h4>
<blockquote>
  $ phonegap local plugin add cordova-plugin-codeplay-share-own-apk
</blockquote>

<h2>How to Uninstall?</h2>
<h4>Using the Cordova CLI</h4>
<blockquote>
  $ cordova plugin rm cordova-plugin-codeplay-share-own-apk
</blockquote>

<h4>Using the phonegap CLI</h4>
<blockquote>
  $ phonegap local plugin rm cordova-plugin-codeplay-share-own-apk
</blockquote>



<h2>Methods 1</h2>
<h3>Check is support or not</h3>
You must check is this support or not then enable the share button, some Android version doesn't support eg) Android 4.4, Android 5.0
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplay_shareapk.isSupport(success,fail);
```

<h4>Example</h4>

```javascript
cordova.plugins.codeplay_shareapk.isSupport(success,fail);

function success(result)
{
 console.log(result);
}
function fail(result)
{
 console.log(result);
}
```



<h2>Methods 2</h2>
<h3>Give your own title</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplay_shareapk.openShare(["Title"]);
```

<h4>Example</h4>

```javascript
cordova.plugins.codeplay_shareapk.openShare("Kindly share our app through");
```

  

<h4>Screenshot</h4>
<p  align="center">
  <img src="https://3.bp.blogspot.com/-wZxpUNJtSNc/XPEtEuKkoZI/AAAAAAAAPbM/s9G-IFquDXUDDpXgHBjxQ_n1aKq-KKtQgCLcBGAs/s1600/Screenshot_2019-05-31-14-29-06-313_android.png" width="350" alt="Share own apk text">
</p>


<h3>Give default title</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplay_shareapk.openShare();
```
  
<h4>Screenshot</h4>
<p  align="center">
  <img src="https://1.bp.blogspot.com/-8FnypU4rF5o/XPEtFHSmleI/AAAAAAAAPbQ/72XaMd9vlYIXysv5xgD1yF4G2ypo-JcHwCLcBGAs/s1600/Screenshot_2019-05-31-14-32-58-561_android.png" width="350" alt="Share own apk default text">
</p>



<h2>Methods 3</h2>
<h3>Custom share apk file name</h3>
<h4>Syntax</h4>

```javascript
cordova.plugins.codeplay_shareapk.openShare(["Title"][,"Apk Name"]);
```

<h4>Example</h4>

```javascript
cordova.plugins.codeplay_shareapk.openShare("Title","My new Apk Name");
```

<h4>Screenshot</h4>
<p  align="center">
  <img src="https://3.bp.blogspot.com/-CN_dIvHzPw8/XPEtGzK4NmI/AAAAAAAAPbU/yUFrg_N9-5MXWASzEO5PUUtpoGAfo7k-wCLcBGAs/s1600/Screenshot_2019-05-31-18-38-15-834_com.whatsapp.png" width="350" alt="Change share apk name">
</p>




<h2>Methods 4</h2>
<h3>Share any file</h3>
<h4>Syntax</h4>



```javascript
cordova.plugins.codeplay_shareapk.openShareFile("Title","New_Filename_with_externsion","file_path");
```

<h4>Example</h4>

```javascript
cordova.plugins.codeplay_shareapk.openShareFile("This is title","mytable.html","/storage/emulated/0/HTMLCodePlayTemp.html")
```

<h4>Screenshot</h4>
<p  align="center">
  <img src="https://1.bp.blogspot.com/-Xslb5cxlSc0/XTMfYOjraHI/AAAAAAAAPqE/YdIAz5gZzB0YhVl-M9kbE239CRgnN7dtwCLcBGAs/s1600/Screenshot_2019-07-20-19-26-58-447_android.png" width="350" alt="Share file popup">
  <img src="https://3.bp.blogspot.com/-1hYhRrSC7EE/XTMfXjHPbKI/AAAAAAAAPqA/QlsWBSRKsPk1_jhoF_Ip37IpLINDqjXiQCLcBGAs/s1600/Screenshot_2019-07-20-19-27-21-868_com.whatsapp.png" width="350" alt="Share in whatsapp">
</p>









<h2>Methods 5</h2>
<h3>Copy given file to specified directory</h3>
Copy the given source file to the given destination directory.
<h4>Syntax</h4>



```javascript
cordova.plugins.codeplay_shareapk.copyFile(sourceFilePath,distinationFolderPath,FileNameWithExternsion);
```

<h4>Example</h4>

```javascript
var sourcePath='/storage/emulated/0/test.jpg';
var distinationPath="/storage/emulated/0/Android/data/com.xxx.xxx/files/";

cordova.plugins.codeplay_shareapk.copyFile(sourcePath,distinationPath,"myfile.jpg");
```












<h2>Support Platfrom</h2>
<ul>
<li>Android</li>
</ul>

<h2>Our Apps</h2>
https://play.google.com/store/apps/details?id=com.HTML.AngularJS.Codeplay

https://play.google.com/store/apps/details?id=sql.code.play

https://play.google.com/store/apps/details?id=html.editor.codeplay

https://play.google.com/store/apps/details?id=php.code.play

https://play.google.com/store/apps/details?id=cordova.code.play

https://play.google.com/store/apps/details?id=com.kids.learning.master

