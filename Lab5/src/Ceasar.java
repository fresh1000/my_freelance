
public class Ceasar implements ICodec {

    private final ICharHelper alphaHelper;
    private final int shift;

    public Ceasar(ICharHelper alpha, int shift)
    {
        this.alphaHelper = alpha;
        int n = alpha.alphabetLength();
        this.shift = (shift + n) % n;
    }

    @Override
    public String encodeCeasar(String message) {
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<message.length(); ++i)
        {
            char c = message.charAt(i);
            char newC = alphaHelper.getChar((alphaHelper.getIndex(c) + shift) % alphaHelper.alphabetLength());
            answer.append(newC);
        }
        return  answer.toString();
    }

    @Override
    public String decodeCeasar(String cipher) {
        int n = alphaHelper.alphabetLength();
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<cipher.length(); ++i)
        {
            char c = cipher.charAt(i);
            char newC = alphaHelper.getChar((alphaHelper.getIndex(c) - shift + n) % n);
            answer.append(newC);
        }
        return  answer.toString();
    }
}
