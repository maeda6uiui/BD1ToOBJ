# BD1ToOBJ

BD1形式のモデルをOBJ形式に変換します。

## 使い方

### オプション一覧

|      オプション      |           意味            |
| :------------------: | :-----------------------: |
| -i, --inputFilepath  | 入力するBD1のファイルパス |
| -o, --outputFilepath | 出力するOBJのファイルパス |
|    -z, --invertZ     |         Z軸を反転         |
|     -f, --flipV      |      UVのV座標を反転      |
|      -h, --help      |       ヘルプを表示        |
|    -v, --version     |   バージョン情報を表示    |

### 使用例

```
bd1-to-obj.exe -i map.bd1 -o map.obj -z -f
```

## 使用上の注意

このプログラムには[JXM (Java XOPSManipulator)](https://github.com/Dabasan/jxm)が使用されています。
JavaがインストールされていないWindowsマシンでも動作するように、Windows用のJREが同封されています。

リリースに含まれる`bd1-to-obj.exe`は内部で`bd1-to-obj.jar`を実行しています。

Windows以外の環境を使用している方は、`bd1-to-obj.jar`を直接実行してください。
この場合には、Java 11以上が必要になります。

## プログラム情報

### 作者

駄場

### バージョン

1.0.0-rc1

### ライセンス

JREのライセンスについては、JRE/legalを参照してください。
その他のファイルはMITライセンスの下に公開されています。

