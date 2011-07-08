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



### アプリケーションプロジェクトの作成と設定

