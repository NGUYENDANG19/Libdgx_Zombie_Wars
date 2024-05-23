package com.game.zombilewars.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.game.zombilewars.objetos.Bullet;
import com.game.zombilewars.objetos.HeroFarmer;
import com.game.zombilewars.objetos.HeroForce;
import com.game.zombilewars.objetos.HeroLumber;
import com.game.zombilewars.objetos.Personajes;
import com.game.zombilewars.objetos.ZombieCuasy;
import com.game.zombilewars.objetos.ZombieFrank;
import com.game.zombilewars.objetos.ZombieKid;
import com.game.zombilewars.objetos.ZombieMummy;
import com.game.zombilewars.objetos.ZombiePan;

public class ObjectCreatorManagerBox2d {

	WorldGame oWorld;
	World oWorldBox;

	public ObjectCreatorManagerBox2d(WorldGame oWorld) {
		this.oWorld = oWorld;
		oWorldBox = oWorld.oWorldBox;
	}

	public void createZombieKid() {
		crearZombieMalo(ZombieKid.class);
	}

	public void createZombieCuasy() {
		crearZombieMalo(ZombieCuasy.class);
	}

	public void createZombieMummy() {
		crearZombieMalo(ZombieMummy.class);
	}

	public void createZombiePan() {
		crearZombieMalo(ZombiePan.class);
	}

	public void createZombieFrank() {
		crearZombieMalo(ZombieFrank.class);
	}

	public void creatHeroForce() {
		crearHero(HeroForce.class);
	}

	public void creatHeroFarmer() {
		crearHero(HeroFarmer.class);
	}

	public void creatHeroLumber() {
		crearHero(HeroLumber.class);
	}

	private void crearZombieMalo(Class<?> tipoZombie) {
		Personajes obj = null;

		BodyDef bd = new BodyDef();
		bd.position.set(16, 1.6f);
		bd.type = BodyType.DynamicBody;

		Body oBody = oWorldBox.createBody(bd);

		if (tipoZombie == ZombieKid.class) {
			obj = new ZombieKid(oBody);
		}
		else if (tipoZombie == ZombieCuasy.class) {
			obj = new ZombieCuasy(oBody);
		}
		else if (tipoZombie == ZombieMummy.class) {
			obj = new ZombieMummy(oBody);
		}
		else if (tipoZombie == ZombiePan.class) {
			obj = new ZombiePan(oBody);
		}
		else if (tipoZombie == ZombieFrank.class) {
			obj = new ZombieFrank(oBody);
		}

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(.17f, .32f);

		FixtureDef fixture = new FixtureDef();
		fixture.shape = shape;
		fixture.density = 8;
		fixture.friction = 0;
		fixture.filter.groupIndex = -1;
		oBody.createFixture(fixture);

		oBody.setFixedRotation(true);
		oBody.setUserData(obj);
		oWorld.arrFacingLeft.add(obj);

		shape.dispose();

	}

	private void crearHero(Class<?> tipoHero) {
		Personajes obj = null;

		BodyDef bd = new BodyDef();
		bd.position.set(1, 1.6f);
		bd.type = BodyType.DynamicBody;

		Body oBody = oWorldBox.createBody(bd);

		if (tipoHero == HeroForce.class) {
			obj = new HeroForce(oBody);
		}
		else if (tipoHero == HeroFarmer.class) {
			obj = new HeroFarmer(oBody);
		}
		else if (tipoHero == HeroLumber.class) {
			obj = new HeroLumber(oBody);
		}

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(.17f, .32f);

		FixtureDef fixture = new FixtureDef();
		fixture.shape = shape;
		fixture.density = 8;
		fixture.friction = 0;
		fixture.filter.groupIndex = -1;
		oBody.createFixture(fixture);

		oBody.setFixedRotation(true);
		oBody.setUserData(obj);
		oWorld.arrFacingRight.add(obj);

		shape.dispose();

	}

	public void createBullet(Personajes oPerWhoFired) {
		Bullet obj;
		BodyDef bd = new BodyDef();

		if (oPerWhoFired.tipo == Personajes.TIPO_RANGO) {
			if (oPerWhoFired.isFacingLeft) {
				bd.position.set(oPerWhoFired.position.x - .42f, oPerWhoFired.position.y - .14f);
			}
			else {
				bd.position.set(oPerWhoFired.position.x + .42f, oPerWhoFired.position.y - .14f);
			}
		}
		else
			bd.position.set(oPerWhoFired.position.x, oPerWhoFired.position.y);

		bd.type = BodyType.DynamicBody;
		Body oBody = oWorldBox.createBody(bd);

		obj = new Bullet(oBody, oPerWhoFired);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(.1f, .1f);

		FixtureDef fixture = new FixtureDef();
		fixture.shape = shape;
		fixture.density = 1;
		fixture.isSensor = true;
		oBody.createFixture(fixture);

		oBody.setFixedRotation(true);
		oBody.setUserData(obj);
		oBody.setBullet(true);
		oBody.setGravityScale(0);
		oWorld.arrBullets.add(obj);

	}

}
