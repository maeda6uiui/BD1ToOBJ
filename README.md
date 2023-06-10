# BD1ToOBJ

BD1形式のモデルをOBJ形式に変換します。

## 使い方

### オプション一覧

|オプション|意味|
|---|---|
|-i, --input-filepath|入力するBD1のファイルパス|
|-o, --output-filepath|出力するOBJのファイルパス|
|-z, --invert-z|Z軸を反転する|
|-f, --flip-v|UVのV座標を反転する|
|-h, --help|ヘルプを表示する|
|-v, --version|バージョン情報を表示する|

### 使用例

```
java -jar bd1-to-obj-1.0.1.jar -i map.bd1 -o map.obj -z -f
```

## プログラム情報

### 作者

駄場

### バージョン

2.0.0

