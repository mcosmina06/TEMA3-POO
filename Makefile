JFLAGS = -g
JC = javac
JVM= java 

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	BasketballTeam.java \
	HandballTeam.java \
	FootballTeam.java \
	Observer.java \
	Competition.java \
	Players.java \
	ScoreVisitor.java \
	Subject.java \
	Team.java \
	TeamFactory.java \
	Visitable.java \
	Visitor.java \
	Main.java \

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(COMANDA) $(IN1) $(IN2) $(OUT)

clean:
	$(RM) *.class
