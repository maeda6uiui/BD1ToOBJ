package com.github.dabasan.bd1_to_obj;

public class BD1ToOBJMain {
	public static void main(String[] args) {
		// コマンドライン引数の形式
		// 0: bd1_to_obj.jar
		// 1: BD1ファイルのファイルパス (変換元)
		// 2: OBJファイルのファイルパス (変換先)
		// 3: Z軸を反転させるかどうか
		if (args.length != 4) {
			System.err.println("エラー: コマンドライン引数の数が不正です。");
			return;
		}

		String filepathBD1 = args[1];
		String filepathOBJ = args[2];

		boolean invertZ;
		if (args[3].equals("false")) {
			invertZ = false;
		} else {
			invertZ = true;
		}

		var bd1ToObj = new BD1ToOBJ();
		int ret = bd1ToObj.convert(filepathBD1, filepathOBJ, invertZ);
		if (ret == -1) {
			System.err.println("エラー: 変換に失敗しました。");
			return;
		}
	}
}
