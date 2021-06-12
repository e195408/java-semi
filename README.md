# 楢崎なゆのjava-semi仕様書
## 国分寺駅周辺のグルメ情報共有システム

### 概要
- 利用者はログインができる。
- 利用者はおすすめ情報の登録ができる。
- 利用者はおすすめ情報の閲覧ができ、閲覧においてSNSが持つ機能を含む。
- 利用者は自分が登録したおすすめ情報を更新できる。
- 利用者はお店を登録することができる。

### 1. ユーザー機能 
#### 1.1. アカウント新規作成機能
ログイン画面の「新規登録」を押すとアカウント作成画面に遷移する。
新規登録に成功するとログイン画面に遷移する。

|入力項目|制約|備考|
|:---:|:---:|:---:|
|ユーザー名|半角20文字以内|null不可|
|メールアドレス|半角255文字以内|null、重複不可|
|パスワード|半角20文字以内|null不可|
|秘密の質問|質問テーブルから選ぶ|null不可、外部キー|
|質問の答え|全角100文字以内|null不可|

#### 1.2. ログイン機能
ログインに成功するとトップページに遷移する。

|入力項目|制約|備考|
|:---:|:---:|:---:|
|メールアドレス|半角255文字以内|null、重複不可|
|パスワード|半角20文字以内|null不可|

#### 1.3. 新規店舗登録
トップページの「新規店舗登録」を押すと新規店舗登録画面に遷移する。
新規店舗登録に成功するとトップページに遷移する。

|入力項目|制約|備考|
|:---:|:---:|:---:|
|店舗名|全角20文字以内|重複不可|
|店舗詳細|全角200文字以内|null可|

#### 1.4. 店舗閲覧機能
トップページに登録されている店舗が表示される。
店舗を選択すると詳細画面に遷移し、レビューが表示される。
詳細画面には、登録されている店舗の詳細と、レビューの内容であるユーザー名、5段階評価、コメントが表示される。
#### 1.5. レビュー作成機能
店舗の詳細画面の「レビュー追加」を押すと、レビュー新規登録画面に遷移する。
レビュー新規登録画面では、5段階評価とコメントを入力できる。
成功すると店舗詳細画面に遷移する。

|入力項目|制約|備考|
|:---:|:---:|:---:|
|評価|1~5を選択|-|
|コメント|全角200文字以内|null可|

#### 1.6. リプライ機能
店舗詳細画面のレビューに「コメント」を押すと、コメント入力画面に遷移し、他の人が書いたレビューに対してコメントすることができる。
成功すると店舗詳細画面に遷移する。

|入力項目|制約|備考|
|:---:|:---:|:---:|
|コメント|全角200文字以内|null不可|

#### 1.7. フォロー機能
ユーザー詳細画面から「フォロー」ボタンを押すとフォローできる。
フォローとは、優先的にフォローしたユーザーのレビューやコメントを見ることができる機能である。
#### 1.8. ログアウト機能
トップページにある、「ログアウト」ボタンを押すと、ログイン画面に遷移する。
#### 1.9. ユーザー検索機能
ユーザー検索画面からユーザーIDを入力すると、検索することができる。
検索を押すと、検索結果画面に遷移する。

|入力項目|制約|備考|
|:---:|:---:|:---:|
|検索したいユーザーID|半角20文字以内|null不可|

#### 1.10. ユーザー詳細表示機能
ユーザーIDを押すと、詳細画面に遷移する。
詳細画面には、IDや今まで投稿した、レビュー、コメントが表示される。
#### 1.11. 店舗詳細更新機能
店舗詳細画面の「編集」ボタンを押すと店舗詳細編集画面に遷移し、店舗の詳細を変更できる。

|入力項目|制約|備考|
|:---:|:---:|:---:|
|店舗詳細|全角200文字以内|null不可|

#### 1.12. パスワード変更機能
ログイン画面、もしくはマイページから「パスワードの変更」を押すと、パスワード再発行画面に遷移する。
新しく設定したいパスワードを入力してもらう。
それと同時に新規アカウント登録の時に設定した秘密の質問に答えてもらう。
答えがあっていたら再発行に成功し、ログイン画面に遷移する。

|入力項目|制約|備考|
|:---:|:---:|:---:|
|新しいパスワード|半角20文字以内|null不可|
|秘密の質問に対する答え|全角100文字以内|null不可|

#### 1.13. アカウント削除機能
マイページの「アカウント削除」ボタンを押すとアカウントが削除できる。
また、アカウントが削除されると、そのユーザーがいままで登録したレコード(店舗登録やレビュー、フォロー)なども関連して削除される。
#### 1.14. 店舗情報削除機能
店舗詳細画面の「店舗削除」を押すと、店舗詳細情報が削除される。
その店舗のレビューとコメントも削除される。
#### 1.15. レビュー削除機能
店舗詳細画面の「レビュー削除」を押すと、レビューが削除される。
そのレビューにコメントされていたリプライも削除される。
#### 1.16. リプライ削除機能
店舗詳細画面の「リプライ削除」を押すと、リプライが削除される。
#### 1.17. フォロー解除機能
フォローしているユーザー詳細画面の「フォローを外す」を押すとフォローが解除される。

### 2. データベース概要
#### 2.1. Userテーブル

|名前|説明|制約|備考
|:---:|:---:|:---:|:---:|
|id|カラム特定のためのID|auto_increment<br>primary key|-
|name|ユーザー名|not null|-
|mail|ユーザーのメールアドレス|not null<br>unique|-
|ps|パスワード|not null|-
|answer|質問の答え|not null|-
|created_at|作成日時|not null|-
|updated_at|更新日時|-|-
|question_id|秘密の質問|not null|外部キー

#### 2.2. Storeテーブル

|名前|説明|制約|
|:---:|:---:|:---:|
|id|カラム特定のためのID|auto_increment<br>primary key|
|name|店舗名|not null<br>unique|
|details|店舗詳細|-|
|created_at|作成日時|not null|
|updated_at|更新日時|-|

#### 2.3. Reviewテーブル

|名前|説明|制約|備考|
|:---:|:---:|:---:|:---:|
|id|カラム特定のためのID|auto_increment<br>primary key|-
|evaluation|評価|not null<br>int|-
|comment|コメント|-|-
|created_at|作成日時|not null|-|
|user_id|ユーザーID|not null|外部キー|
|store_id|店舗ID|not null|外部キー|

#### 2.4. Replyテーブル

|名前|説明|制約|備考|
|:---:|:---:|:---:|:---:|
|id|カラム特定のためのID|auto_increment<br>primary key|-
|Reply|リプライ|not null|-
|created_at|作成日時|not null|-
|user_id|ユーザーID|nut null|外部キー
|review_id|レビューID|not null|外部キー

#### 2.5. UserとUserの中間テーブル(フォロー機能について)

|名前|説明|制約|備考|
|:---:|:---:|:---:|:---:|
|id|カラム特定のためのID|auto_increment<br>primary key|-|
|follow_user_id|フォローする側のユーザーID|not null|外部キー|
|follower_user_id|フォローされる側のユーザーID|not null|外部キー|

#### 2.6. 質問テーブル

|名前|説明|制約|備考|
|:---:|:---:|:---:|:---:|
|id|カラム特定のためのID|auto_increment<br>primary key|-|
|question|質問内容|not null|-

