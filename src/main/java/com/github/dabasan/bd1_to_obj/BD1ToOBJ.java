package com.github.dabasan.bd1_to_obj;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.github.dabasan.jxm.bd1.BD1Manipulator;

/**
 * BD1をOBJに変換します。
 * 
 * @author Daba
 *
 */
public class BD1ToOBJ {
	public BD1ToOBJ() {

	}

	/**
	 * 変換処理
	 * 
	 * @param filepathBD1
	 *            BD1ファイルのファイルパス
	 * @param filepathOBJ
	 *            OBJファイルのファイルパス
	 * @param invertZ
	 *            Z軸を反転するかどうか
	 * @return エラー: -1 成功: 0
	 */
	public int convert(String filepathBD1, String filepathOBJ, boolean invertZ) {
		BD1Manipulator manipulator;
		try {
			manipulator = new BD1Manipulator(filepathBD1);
		} catch (IOException e) {
			System.err.println("Java-side error: Failed to open file.");
			e.printStackTrace();

			return -1;
		}

		if (invertZ) {
			manipulator.invertZ();
		}

		String baseFilepathOBJ = this.getBaseFilepath(filepathOBJ);
		String filepathMTL = baseFilepathOBJ + ".mtl";

		Path pathMTL = Paths.get(filepathMTL);
		String filenameMTL = pathMTL.getFileName().toString();

		return manipulator.saveAsOBJ(filepathOBJ, filepathMTL, filenameMTL, false);
	}
	private String getBaseFilepath(String filepath) {
		int lastDotPos = filepath.lastIndexOf('.');
		if (lastDotPos == -1) {
			return filepath;
		}

		return filepath.substring(0, lastDotPos);
	}
}
