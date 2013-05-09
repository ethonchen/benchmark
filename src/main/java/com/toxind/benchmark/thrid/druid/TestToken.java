package com.toxind.benchmark.thrid.druid;

import com.alibaba.druid.sql.parser.Lexer;
import com.alibaba.druid.sql.parser.Token;

public class TestToken {

	public static void main(String[] args) {
		String sql = "SELECT * FROM T WHERE F1 = ? ORDER BY F2";
		Lexer lexer = new Lexer(sql);
		for (;;) {
			lexer.nextToken();
			Token tok = lexer.token();

			if (tok == Token.IDENTIFIER) {
				System.out.println(tok.name() + "\t\t" + lexer.stringVal());
			} else {
				System.out.println(tok.name() + "\t\t\t" + tok.name);
			}

			if (tok == Token.EOF) {
				break;
			}
		}
	}

}
