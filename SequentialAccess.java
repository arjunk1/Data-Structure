import java.io.*;


public class SequentialAccess {
    public static final int size = 100;
    public static void main(String[] args) throws Exception {
        String fileinput = args[0];
        String seqaccfile = args[1];
        String ranaccfile = args[2];
        FileReader f = new FileReader(fileinput);
        StreamTokenizer t = new StreamTokenizer(f);
        FileOutputStream fo = new FileOutputStream(seqaccfile);
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        RandomAccessFile ran = new RandomAccessFile(ranaccfile, "rw");
        t.resetSyntax();
        t.wordChars(33, 255);
        t.whitespaceChars(0, ' ');
        String collector;
        while (t.nextToken() != t.TT_EOF) {
        if (t.ttype == t.TT_WORD) {
            String s1 = t.sval;
            t.nextToken();
            collector = t.sval;
            Integer i1 = Integer.parseInt(collector);
            t.nextToken();
            collector = t.sval;
            Integer i2 = Integer.parseInt(collector);
            t.nextToken();
            collector = t.sval;
            Integer i3 = Integer.parseInt(collector);
            t.nextToken();
            collector = t.sval;
            Integer i4 = Integer.parseInt(collector);
            RecDef r = new RecDef(s1, i1, i2, i3, i4);
            try {
                oo.writeObject(r);
                oo.flush();
            }
            catch (Exception e) {
                System.out.println(e);
                System.exit(0);
            }
        }
        }
        f.close();
        oo.close();
        
        System.out.println("--------SEQUENTIAL FILE CONTENT--------");
        
        FileInputStream fr = new FileInputStream(seqaccfile);
        ObjectInputStream or = new ObjectInputStream(fr);
        
        while (true) {
            try {
                RecDef readrec = (RecDef) or.readObject();
                String sread1 = readrec.s1;
                Integer iread1 = readrec.i1;
                Integer iread2 = readrec.i2;
                Integer iread3 = readrec.i3;
                Integer iread4 = readrec.i4;
                System.out.println(sread1);
                System.out.print(iread1);
                System.out.print(' ');
                System.out.print(iread2);
                System.out.print(' ');
                System.out.print(iread3);
                System.out.print(' ');
                System.out.println(iread4);
            }
            catch (EOFException eof1) {
                or.close();
                break;
            }
            catch (Exception e) {
                System.out.println(e);
            }
            
        }
    
    FileInputStream f1 = new FileInputStream(seqaccfile);
    ObjectInputStream o1 = new ObjectInputStream(f1);
    int fnumber = 0;
    StringBuffer b = null;
    while (true) {
        try {
        RecDef record = (RecDef) o1.readObject();
        ran.seek(fnumber*size);
        b = new StringBuffer(record.s1);
        b.setLength(20);
        ran.writeChars(b.toString());
        ran.writeInt(record.i1);
        ran.writeInt(record.i2);
        ran.writeInt(record.i3);
        ran.writeInt(record.i4);
        fnumber++;
        }
        catch (EOFException eof) {
            o1.close();
            break;
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    

    
    System.out.println("--------RANDOM FILE CONTENT--------");
    
    Integer pos = 0;
    while (true) {
        try {
            Integer standby;
            char word[] = new char[50];
            ran.seek(pos*size);
            for (int a = 0; a < 20; a++) {
                word[a] = ran.readChar();
            }
            System.out.println(word);
            standby = ran.readInt();
            System.out.print(standby);
            System.out.print(' ');
            standby = ran.readInt();
            System.out.print(standby);
            System.out.print(' ');
            standby = ran.readInt();
            System.out.print(standby);
            System.out.print(' ');
            standby = ran.readInt();
            System.out.println(standby);
            pos++;
        }
        catch (EOFException eof2) {
            ran.close();
            System.exit(0);
            break;
        }
        catch (Exception e3) {
            System.out.println(e3);
        }
    }
    
    }
}
