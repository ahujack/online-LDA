package vagueobjects.ir.lda.tokens;

/*
Copyright (c) 2013 miberk

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class PlainVocabulary implements Vocabulary{
	String charset = "utf-8";
    final List<String> strings =new ArrayList<String>();

    public PlainVocabulary(Collection<String> strings) {
        this.strings.addAll(strings);
    }

    public PlainVocabulary(String path ) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(path)),"UTF-8");
        BufferedReader in  = new BufferedReader(isr);
        String line = null;
        while ((line = in.readLine()) != null){
            strings.add(line.trim());
        }
 //       System.out.println(strings);
        in.close();
    }

    @Override
    public boolean contains(String token) {
        return strings.contains(token);
    }

    @Override
    public int size() {
        return strings.size();
    }

    @Override
    public int getId(String token) {
        for(int i=0; i< strings.size();++i){
            if(strings.get(i).equals(token)){
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getToken(int id) {
        return strings.get(id);
    }
}
