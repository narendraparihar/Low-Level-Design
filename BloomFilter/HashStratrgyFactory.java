public class HashStratrgyFactory {

    public static HashStratergy create(HashTypes type) {
        switch (type) {
            case FNV1A:
                return new F1NV1AHashStratergy();
            case DJB2:
                return new DJB2HashStratergy();
            default:
                throw new IllegalArgumentException("Invalid stratrgy type");
        }
    }

}