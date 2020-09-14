package main

import (
	"flag"
	"fmt"
	"os"
	"os/exec"
	"path/filepath"
)

func main() {
	var err error

	//JREのディレクトリ名を絶対パスに変換する。
	pathJRE, err := filepath.Abs(".\\jre\\bin")
	if err != nil {
		panic(err)
	}

	//JREのディレクトリをPATHに追加する。
	paths := os.Getenv("PATH")
	paths = pathJRE + ";" + paths

	err = os.Setenv("PATH", paths)
	if err != nil {
		panic(err)
	}

	//コマンドライン引数の解析を行う。
	// 0: BD1ファイルのファイルパス (変換元)
	// 1: OBJファイルのファイルパス (変換先)
	// 2: Z軸を反転させるかどうか
	// 3: テクスチャのV座標を反転するかどうか
	flag.Parse()
	if len(flag.Args()) < 4 {
		fmt.Fprintln(os.Stderr, "Go-side error: Invalid number of command-line arguments.")
		return
	}

	//bd1_to_obj.jarを実行する。
	cmd := exec.Command("java", "-jar", "bd1_to_obj.jar", flag.Arg(0), flag.Arg(1), flag.Arg(2), flag.Arg(3))
	output, err := cmd.CombinedOutput()
	if err != nil {
		fmt.Println(fmt.Sprint(err) + ": " + string(output))
		return
	}

	fmt.Println(string(output))
}
