# 本管理アプリ

# 概要
このアプリでは"BookregistrationServlet.java"と"RegistrationServlet.java"の2つのサーブレットで構成されており  
それぞれ書籍情報の登録とユーザー登録・削除を処理します。サーブレットはJSPページを利用して転送およびリダイレクトを行います。  


https://github.com/hayato6911/BookManagement_App/assets/81948704/0df8e2ff-c0b3-49ee-a10a-85b2bb11626e

# 使用言語と使用技術
<h3>プログラミング言語</h3> 

・**JAVA(11)**  

<h3>ウェブテクノロジー</h3>  

・**JSP,Servlet**

<h3>開発環境</h3>  

・**Eclipse**

<h3>サーバー</h3>  

・**Apache Tomcat9**

# 機能
<h3>RegistrationServlet.java</h3>
RegistrationServletは、ユーザーの登録情報を受け取り、書籍情報一覧ページにリダイレクトします。また、ユーザー登録情報を一定時間保持し、その後自動的に削除します。  

<h3>処理の流れ</h3>

1.リクエストのエンコーディングをUTF-8に指定  

2.送られてきたユーザー名とパスワードを受け取る  

3.ユーザー登録成功時は書籍情報一覧画面にリダイレクト  

4.ユーザー登録情報を一定時間保持し、60分経過後登録されたユーザーは削除される  
※以下は参考動画のため、ユーザー削除時間を早めて録画しております。


https://github.com/hayato6911/BookManagement_App/assets/81948704/7efe212e-1f75-43fe-8acc-f32caf4dc731

