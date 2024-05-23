package com.game.zombilewars.objetos;

import com.badlogic.gdx.physics.box2d.Body;
import com.game.zombilewars.Assets;


public class ZombieMummy extends Personajes {

	public ZombieMummy(Body body) {
		super(body);
		DURATION_ATTACK = Assets.zombieMummyAttack.animationDuration;
		DURATION_DEAD = Assets.zombieMummyDie.animationDuration + .2f;
		VELOCIDAD_WALK = .5f;
		DISTANCE_ATTACK = .35f;
		DAMAGE = 1;
		vidas = 3;
		isFacingLeft = true;
		tipo = TIPO_NO_RANGO;
	}

}
