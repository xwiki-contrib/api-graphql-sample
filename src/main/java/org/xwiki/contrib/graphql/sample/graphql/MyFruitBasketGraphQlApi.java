/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.graphql.sample.graphql;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.NonNull;
import org.eclipse.microprofile.graphql.Query;
import org.xwiki.contrib.graphql.sample.model.Apple;
import org.xwiki.contrib.graphql.sample.model.Banana;
import org.xwiki.contrib.graphql.sample.model.Basket;
import org.xwiki.contrib.graphql.sample.model.Fruit;
import org.xwiki.contrib.graphql.sample.model.Orange;

/**
 * @version $Id$
 */
@GraphQLApi
public class MyFruitBasketGraphQlApi
{
    // Imagine this is returned by some BasketRepository component.
    // XXX: Making it static for now because the API is reinitialized at each call ATM so changes would not be
    // persisted otherwise.
    private static Basket basket = new Basket()
    {
        {
            this.addFruit(new Apple());
            this.addFruit(new Apple());
            this.addFruit(new Orange());
            this.addFruit(new Banana());
        }
    };

    @Query
    @Description("Get the basket of fruits")
    public Basket getBasket()
    {
        return basket;
    }

    @Mutation
    @Description("Add a fruit of a specified type")
    public Fruit addFruit(@NonNull String type)
        throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        Fruit fruit = (Fruit) Class.forName("org.xwiki.contrib.graphql.sample.model." + type).newInstance();

        basket.addFruit(fruit);

        return fruit;
    }

    @Mutation
    @Description("Remove the fruit at the specified 0-starting index")
    public Fruit removeFruit(@NonNull int index)
    {
        return basket.removeFruit(index);
    }
}
