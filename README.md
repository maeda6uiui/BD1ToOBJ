# bd1-to-obj

BD1形式のモデルをOBJ形式に変換します。

# 使い方

```
bd1_to_obj.exe \
	(BD1のファイルパス) \
	(OBJのファイルパス) \
	(Z軸を反転するかどうか) \
	(テクスチャのV座標を反転するかどうか) 
```

例

```
bd1_to_obj.exe map.bd1 map.obj true true
```

## 使用上の注意

このプログラムには[JXM (Java XOPSManipulator)](https://github.com/Dabasan/jxm)が使用されています。
JavaがインストールされていないWindowsマシンでも動作するように、Windows用のJREが同封されています。

リリースに含まれる`bd1_to_obj.exe`は内部で`bd1_to_obj.jar`を実行しています。

Windows以外の環境を使用している方は、`bd1_to_obj.jar`を直接実行してください。
この場合には、Java 11以上が必要になります。

# プログラム情報

## 作者

駄場

## バージョン

0.0.1

## ライセンス

JREのライセンスはjre/legalを参照してください。

その他のファイルについては、MITライセンスの下に公開されています。

