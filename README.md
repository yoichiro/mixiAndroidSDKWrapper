# mixiAndroidSDKWrapper

このプロジェクトは、mixi API SDK for Android(TM) をより便利に利用できるように機能拡張を行う
ためのソフトウェアです。

    mixiWrapper.getPeopleAPI().getFriends(
                    new GetPeopleCallbackHandler() {
        protected void handleResult(boolean canceled) {
            for (Person friend : getPeople()) {
                // do something...
            }
        }
    });

mixi Platformでは、多くのAPIが提供されています。これらのAPIをSDKから呼び出すためには、各API
の仕様を細かく理解している必要があります。本ラッパーを適用することで、APIを呼び出すためのコーディン
グが、より直感的なものになります。また、API呼び出しによって得られた情報について、本ラッパーが自動的
に各種モデルオブジェクトにマッピングします。これにより、開発者は自分が作りたいソフトウェアの開発に
集中することができるようになるでしょう。

## インストール

mixiAndroidSDKWrapperをインストールして利用可能にするには、以下の手順を行います。

 * mixi API SDK for Android(TM)のインストール
 * mixiAndroidSDKWrapperのインストール
 * アプリケーションプロジェクトの作成と設定

### mixi API SDK for Android(TM)のインストール

最初にmixi Developer Centerにて配布されているmixi API SDK for Android(TM)をダウンロード
し、その後インストールします。mixi API SDK for Android(TM)は、以下の場所から最新版を入手しま
す。

[SDKダウンロード](http://developer.mixi.co.jp/appli/spec/android/download/)

ダウンロード後、Eclipseのワークスペースディレクトリ内でzipファイルを展開します。そして、Eclipse
を起動し、[File]->[Import...]->[General]->[Existing projects into Workspace]を選択
し、先ほど展開したmixiAndroidSDKディレクトリを選択してインポートします。

### mixiAndroidSDKWrapperのインストール

以下のGitHubリポジトリから、mixiAndroidSDKWrapperをダウンロードします。

[mixiAndroidSDKWrapper](https://github.com/yoichiro/mixiAndroidSDKWrapper)

ダウンロードしたtar ball形式もしくはzip形式のアーカイブを、Eclipseのワークスペースディレクトリ
内で展開します。先ほど展開したmixi API SDK for Android(TM)と同じ場所が良いでしょう。そして、
Eclipseを起動し、[File]->[Import...]->[General]->
[Existing projects into Workspace]を選択し、先ほど展開したmixiAndroidSDKWrapper
ディレクトリを選択してインポートします。

もしmixi API SDK for Android(TM)と同じディレクトリに展開しなかった場合は、
mixiAndroidSDKWrapperディレクトリにあるdefault.propertiesファイルについて、以下の修正を
行う必要があります。

    android.library.reference.1=[mixiAndroidSDKディレクトリのパス]

この記述により、mixi API SDK for Android(TM)とmixiAndroidSDKWrapperとが関連づけられま
す。

### アプリケーションプロジェクトの作成と設定

開発したいアプリケーションのAndroidプロジェクトを作成します。その後、作成されたプロジェクトに含まれ
るdefault.propertiesファイルに以下を追記します。

    android.library.reference.1=[mixiAndroidSDKWrapperディレクトリのパス]

これにより、mixiAndroidSDKWrapperを利用可能となります。

## 利用方法

mixiAndroidSDKWrapperを利用するための手順は以下となります。Developer Dashboardでの
アプリケーションの登録などは、以下のページを参考にして事前に済ませておいてください。

[アプリケーションの登録](http://developer.mixi.co.jp/appli/spec/android/register-application/)

### MixiWrapperオブジェクトの生成

mixiAndroidSDKWrapperの中心的なインタフェースは、MixiWrapperインタフェースとなります。開発者
はこのインタフェースによって提供される各種機能を利用することになります。

MixiWrapperオブジェクトを生成するために、以下のコードを実行します。

    String clientId = ...; // Client ID
    // mixiアプリとして利用する場合
    MixiWrapper mixiWrapper = new MixiWrapperFactory().createForMixiApp(clientId);
    // mixi Graph APIを利用する場合
    MixiWrapper mixiWrapper = new MixiWrapperFactory().createForGraphAPI(clientId);

### 初期化と認可処理

MixiWrapperオブジェクトから、MixiContainerオブジェクトを以下のように取得することができます。

    MixiContainer container = mixiWrapper.getContainer();

MixiContainerオブジェクトを利用して、初期化と認可処理を各Activityオブジェクト内で行います。初
期化と認可処理の方法は、以下のページを参照ください。

[初期化と認可処理](http://developer.mixi.co.jp/appli/spec/android/init-and-auth/)

### APIの呼び出し

各APIの呼び出しは、MixiWrapperオブジェクトから呼び出したいAPIが含まれるProxyオブジェクトを取得
することから始まります。たとえば、Photo APIを利用したい場合は、以下のコードを実行します。

    PhotoAPI photoAPI = mixiWrapper.getPhotoAPI();

mixi API SDK for Android(TM)におけるAPI呼び出しは、基本的に全てsend()メソッドを利用します
が、mixiAndroidSDKWrapperでは具体的なAPIごとに専用のメソッドが提供されています。また、API呼び
出しの結果得られたJSON文字列を解釈して各モデルオブジェクトにマッピングするための各種コールバック
リスナクラスも、本ラッパーにて提供されます。

たとえば、ある友人が持つフォトアルバムの一覧は、以下のコードで取得可能です。

    Context context = ...; // ActivityなどのContextオブジェクト
    String userId = ...; // 友人のユーザID
    photoAPI.getFriendAlbums(userId, new GetAlbumsCallbackHandler(context) {
        protected void handleResult(boolean canceled) {
            for (Album album : getAlbums()) {
                // do something...
            }
        }
    });

このように、より直感的にAPI呼び出しのためのコードを記述することが可能です。Eclipseの補完機能を
生かしながらコーディングすることができるようになるでしょう。

### CallbackAdapter

APIの呼び出し後の処理を担当するオブジェクトとして、本ラッパーではCallbackAdapterクラスあるいは
そのサブクラスが提供されます。

CallbackAdapterでは、API呼び出しの成功/失敗に関わらず、何らかの前処理を行うタイミングを得るため
に、preprocess()メソッドが呼び出されます。このメソッド内で、たとえば処理中表示を消去したりすると
いったことを実行することが可能です。

preprocess()メソッドの復帰後、API呼び出しの結果に応じて各メソッドが呼び分けられます。API呼び出し
が正常に行われた、あるいはユーザによりAPI呼び出しがキャンセルされた、といった状況の時には、
handleResult()メソッドが呼び出されます。通常はこのメソッドをオーバーライドして、アプリケーション
固有の処理を記述すると良いでしょう。CallbackAdapterのサブクラスでは、すでにonComplete()
メソッド内で処理結果がパースされ、handleResult()メソッドにてサブクラス固有のgetterメソッドを
利用して、パース後のモデルオブジェクトを得ることができます。

API呼び出しが何らかの理由で失敗した場合は、onError()あるいはonFatal()メソッドが呼び出されます。
この2つのメソッドでは、エラーの内容をAlertDialogにて表示する実装が記述されています。もし他の処理を
行いたい場合は、これらのメソッドをオーバーライドして独自の処理を記述してください。

## 開発者の方々へ

mixiAndroidSDKWrapperの品質を低コストで継続的に高く保つために、テストプロジェクトが準備されて
います。

[mixiAndroidSDKWrapperTest](https://github.com/yoichiro/mixiAndroidSDKWrapperTest)

mixiAndroidSDKWrapper内のコードに何らかの修正が加えられた際には、原則として上記のテスト
プロジェクトに対してその修正を確認するためのコードを追記しなければなりません。これにより、常にテスト
可能な状態とし、将来的なリファクタリングの実施可能性を確保します。
