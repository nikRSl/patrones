import java.util.ArrayList;
import java.util.List;

class Personalidad implements Cloneable {
    private int nivelEmpatia;
    private List<String> frases;

    public Personalidad(String tipo, int nivelEmpatia, List<String> frases) {
        this.nivelEmpatia = nivelEmpatia;
        this.frases = new ArrayList<>(frases);
    }

    public void setNivelEmpatia(int nivelEmpatia) {
        this.nivelEmpatia = nivelEmpatia;
    }

    public int getNivelEmpatia() {
        return nivelEmpatia;
    }

    @Override
    public Personalidad clone() {
        try {
            Personalidad copia = (Personalidad) super.clone();
            copia.frases = new ArrayList<>(this.frases);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Robot {
    private Personalidad personalidad;
    private int altura;
    private String voz;
    private int energia;
    private List<String> modulos;

    private Robot(Builder builder) {
        this.personalidad = builder.personalidad;
        this.altura = builder.altura;
        this.voz = builder.voz;
        this.energia = builder.energia;
        this.modulos = new ArrayList<>(builder.modulos);
    }

    public static class Builder {
        private Personalidad personalidad;
        private int altura;
        private String voz = "Neutral";
        private int energia = 100;
        private List<String> modulos = new ArrayList<>();

        public Builder(Personalidad personalidad) {
            this.personalidad = personalidad;
        }

        public Builder altura(int altura) {
            this.altura = altura;
            return this;
        }

        public Builder voz(String voz) {
            this.voz = voz;
            return this;
        }

        public Builder agregarModulo(String modulo) {
            this.modulos.add(modulo);
            return this;
        }

        public Builder energia(int energia) {
            this.energia = energia;
            return this;
        }

        public Robot build() {
            return new Robot(this);
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "nivelEmpatia=" + personalidad.getNivelEmpatia() +
                ", altura=" + altura +
                ", voz='" + voz + '\'' +
                ", energia=" + energia +
                ", modulos=" + modulos +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        Personalidad empaticaBase = new Personalidad(
                "Empática",
                9,
                List.of("Estoy aquí contigo")
        );

        Personalidad personalizada = empaticaBase.clone();
        personalizada.setNivelEmpatia(10);

        Robot robotInfantil = new Robot.Builder(personalizada)
                .altura(120)
                .voz("Suave")
                .agregarModulo("Detector emocional")
                .agregarModulo("Cuentacuentos")
                .energia(150)
                .build();

        System.out.println("Robot creado correctamente: " + robotInfantil);
    }
}